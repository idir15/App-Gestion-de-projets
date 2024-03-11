import React, { useState, useEffect } from "react";
import { Badge, Button, Card, Navbar, Nav, Table, Container, Row, Col } from "react-bootstrap";

function Task() {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    // Effect to fetch tasks from the backend when the component mounts
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    try {
      // Replace 'your-api-endpoint' with the actual endpoint from your Spring Boot backend
      const response = await fetch('http://localhost:8080/api/v1/getAllTasks');
      
      if (response.ok) {
        const tasksData = await response.json();
        setTasks(tasksData);
      } else {
        console.error('Failed to fetch tasks');
      }
    } catch (error) {
      console.error('Error fetching tasks:', error);
    }
  };

  return (
    <>
      <Container fluid>
        <Row>
          <Col md="12">
            <Card className="strpied-tabled-with-hover">
              <Card.Header>
                <Card.Title as="h4">Striped Table with Hover</Card.Title>
                <p className="card-category">
                  Here is a subtitle for this table
                </p>
              </Card.Header>
              <Card.Body className="table-full-width table-responsive px-0">
                <Table className="table-hover table-striped">
                  <thead>
                    <tr>
                      <th className="border-0">Name</th>
                      <th className="border-0">Person</th>
                      <th className="border-0">Project</th>
                      <th className="border-0">Start date</th>
                      <th className="border-0">End date</th>
                      <th className="border-0">State</th>
                      <th className="border-0"></th>
                    </tr>
                  </thead>
                  <tbody>
                    {tasks.map(task => (
                      <tr key={task.id}>
                        <td>{task.name}</td>

                        <td>{task.start_date}</td>
                        <td>{task.end_date}</td>
                        <td>{task.state ? 'Terminé' : 'En cours' }</td>
                        <td>+</td>
                      </tr>
                    ))}
                  </tbody>
                </Table>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    </>
  );
}

export default Task;
