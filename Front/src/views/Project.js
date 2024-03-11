import React, { useState, useEffect } from 'react';

// react-bootstrap components
import {
  Badge,
  Button,
  Card,
  Navbar,
  Nav,
  Form,
  Table,
  Container,
  Row,
  Col,
} from "react-bootstrap";

function Project() {
 const [project, setProject]= useState([])   
 const [showForm, setShowForm] = useState(false);

 const [formData, setFormData] = useState({
    name: '',
    state: '',
    startDate: '',
    endDate: '',
    description: ''
    
  });
  
  const handleInputChange = (e, fieldName) => {
    const value = e.target.value;
    setFormData({
      ...formData,
      [fieldName]: value,
    });
  };
  

 useEffect(() => {
    // Effect to fetch project from the backend when the component mounts
    fetchProject();
  }, []);
 
  const fetchProject = async () => {
    try {
      
      const response = await fetch('http://localhost:8080/api/v1/getAllproject');
     
      if (response.ok) {
        const projectData = await response.json();
        setProject(projectData);
      } else {
        console.error('Failed to fetch project');
      }
    } catch (error) {
      console.error('Error fetching project:', error);
    }
  };

  const handleAddProjectClick = () => {
    
    setShowForm(true);
  };
  const handleFormSubmit = async (formData) => {
    try {
      if (formData.id) {
        // Mettez à jour le projet existant
        const response = await fetch(`http://localhost:8080/api/v1/updateProject/${formData.id}`, {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(formData),
        });
  
        if (response.ok) {
          console.log('Projet mis à jour avec succès');
          setShowForm(false);
          fetchProject();
        } else {
          console.error('Erreur lors de la mise à jour du projet');
        }
      } else {
        // Ajoutez un nouveau projet
        const response = await fetch('http://localhost:8080/api/v1/postAddproject', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(formData),
        });
  
        if (response.ok) {
          console.log('Projet ajouté avec succès');
          setShowForm(false);
          fetchProject();
        } else {
          console.error('Erreur lors de l\'ajout du projet');
        }
      }
    } catch (error) {
      console.error('Erreur réseau', error);
    }
  };

  const handleDeleteProject = async (projectId) => {
    try {
      const response = await fetch(`http://localhost:8080/api/v1/deleteProject/${projectId}`, {
        method: 'DELETE',
      });
  
      if (response.ok) {
        console.log('Projet supprimé avec succès');
        fetchProject(); // Refresh the project list after deletion
      } else {
        console.error('Erreur lors de la suppression du projet');
      }
    } catch (error) {
      console.error('Erreur réseau', error);
    }
  };
  const handleUpdateProject = async (projectId) => {
  try {
    const response = await fetch(`http://localhost:8080/api/v1/getProject/${projectId}`);
    
    if (response.ok) {
      const detailsProjet = await response.json();
      
      console.log('Détails du projet récupérés avec succès:', detailsProjet);

      // Afficher le formulaire avec les détails du projet existant
      setFormData({
        name: detailsProjet.name,
        description: detailsProjet.description,
        startDate: detailsProjet.startDate,
        endDate: detailsProjet.endDate,
        state: detailsProjet.state ? 'Terminée' : 'En cours',  
      });
      
      setShowForm(true);
    } else {
      console.error('Erreur lors de la récupération des détails du projet. Statut:', response.status);
    }
  } catch (error) {
    console.error('Erreur réseau', error);
  }
};

  
  
      
 
  return (
    <>
      <Container fluid>
        <Row>
          <Col  className='ellipsis'>
            {showForm ? (
              // Render the form when showForm is true
              <ProjectForm onSubmit={handleFormSubmit} onCancel={() => setShowForm(false)} />
            ) : (
              // Render the project list when showForm is false
              <Card className="strpied-tabled-with-hover ellipsis">
                <Card.Header className='ellipsis'>
                  <Card.Title as="h4">Gestion des projets</Card.Title>
                  <Button variant="primary" className="float-right" onClick={handleAddProjectClick}>
                    Ajout Projet
                  </Button>
                </Card.Header>
                <Card.Body className="table-full-width table-responsive px-0 ellipsis" >
                <Table className="table-hover table-striped ">
                  <thead>
                    <tr>
                     
                      <th className="border-0">Nom du projet</th>
                      <th className="border-0">Description</th>
                      <th className="border-0">Date de debut</th>
                      <th className="border-0">Date de fin</th>
                      <th className="border-0">Etat du projet</th>
                      <th className="border-0">Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {project.map(project => (
                      <tr key={project.id}>
                        <td className='ellipsis'>{project.name}</td>
                        <td className='ellipsis'>{project.description}</td>
                        <td className='ellipsis'>{project.startDate}</td>
                        <td className='ellipsis'>{project.endDate}</td>
                        <td className='ellipsis'>{project.state ? 'Terminé' : 'En cours'}</td>

                        <td>
                            <Button type="radio" autocomplete="off" checked variant="info" onClick={() => handleUpdateProject(project.id)}>
                                 Modifier
                            </Button>
                            {' '}
                            <Button type="radio" autocomplete="off" variant="danger" onClick={() => handleDeleteProject(project.id)}>
                                Supprimer
                            </Button>
                        </td>
                        
                       
                      </tr>
                    ))}
                  </tbody>
                </Table>
                </Card.Body>
              </Card>
            )}
          </Col>
        </Row>
      </Container>
    </>
  );
}


const ProjectForm = ({ onSubmit, onCancel, formData: initialFormData }) => {
    const [formData, setFormData] = useState(initialFormData || {
      name: '',
      description: '',
      startDate: '',
      endDate: '',
      state: true,
    });
  
    const handleInputChange = (e) => {
      const { name, value } = e.target;
      setFormData({ ...formData, [name]: value });
    };
  
    const handleSubmit = (e) => {
      e.preventDefault();
      // Call the onSubmit prop with the form data
      onSubmit(formData);
    };
   
  
    return (
      <Card>
        <Card.Header>
          <Card.Title as="h4">Ajouter un projet</Card.Title>
          <Button variant="secondary" className="float-right" onClick={onCancel}>
            Annuler
          </Button>
        </Card.Header>
        <Card.Body>
          <form onSubmit={handleSubmit}>
            
<Row>
    
  <Col className="px-1" md="6">
    <Form.Group>
      <Form.Label>Nom du projet</Form.Label>
      <Form.Control
        placeholder="Nom du projet"
        type="text"
        name="name" 
        value={formData.name}  
        onChange={(e) => handleInputChange(e)}  
      />
    </Form.Group>
  </Col>

  <Col className="px-1" md="6">
    <Form.Group>
      <Form.Label>Etat du projet</Form.Label>
      <Form.Control
        placeholder="etat"
        type="text"
        name = "state"
        value={formData.state}  
        onChange={(e) => handleInputChange(e)}  
      />
    </Form.Group>
  </Col>

</Row>
<Row>
  <Col className="px-1" md="6">
    <Form.Group>
      <Form.Label>Date de debut</Form.Label>
      <Form.Control
        placeholder="Date de debut"
        type="text"
        name="startDate"
        value={formData.startDate}  
        onChange={(e) => handleInputChange(e)}  
      />
    </Form.Group>
  </Col>

  <Col className="px-1" md="6">
    <Form.Group>
      <Form.Label>Date de fin</Form.Label>
      <Form.Control
        placeholder="Date de fin"
        type="text"
        name="endDate"
        value={formData.endDate}  
        onChange={(e) => handleInputChange(e)}  
      />
    </Form.Group>
  </Col>

</Row>

<Row>
<Col className="px-1" md="12">
    <Form.Group>
      <Form.Label>Description du projet</Form.Label>
      <Form.Control
        cols="80"
        placeholder="Description"
        rows="4"
        as="textarea"
        type="text"
        name="description"
        value={formData.description}  
        onChange={(e) => handleInputChange(e)}  
      />
    </Form.Group>
  </Col>
</Row>
  
            <Button variant="primary" type="submit">
              Enregistrer
            </Button>
          </form>
        </Card.Body>
      </Card>
    );
  };

export default Project;
