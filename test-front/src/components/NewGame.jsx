import React from "react";
import { Row, Col, Form, Button } from "react-bootstrap";
import { useFormFields } from "../utils/useFormFields";
import { addGame } from "../apis/addGame";
import useFetchData from "../apis/useFetchData";

const NewGame = () => {
  const [fields, handleFieldChange] = useFormFields();
  const { data: teams } = useFetchData("/reprezentacije");
  return (
    <Form>
      {/* <Form.Label>Medalje od</Form.Label>
          <Form.Control
            id="medalsFrom"
            type="number"
            onChange={(e) => handleFieldChange(e)}
          /> */}
      <Form.Label>Reprezentacija A</Form.Label>
      <Form.Control
        as="select"
        id="teamAID"
        onChange={(e) => handleFieldChange(e)}
      >
        <option></option>
        {teams?.map((team) => {
          return (
            <option key={team.id} value={team.id}>
              {team.tag}
            </option>
          );
        })}
      </Form.Control>
      <Form.Label>Reprezentacija B</Form.Label>
      <Form.Control
        as="select"
        id="teamBID"
        onChange={(e) => handleFieldChange(e)}
      >
        <option></option>
        {teams?.map((team) => {
          return (
            <option key={team.id} value={team.id}>
              {team.tag}
            </option>
          );
        })}
      </Form.Control>

      <Button style={{ marginTop: "25px" }} onClick={() => addGame(fields)}>
        New Game
      </Button>
    </Form>
  );
};

export default NewGame;

{
  /* <Row>
        <Col></Col>
        <Col xs="12" sm="10" md="8">
          <h1>Dodaj takmicara</h1>
          <Form>
            <Form.Label htmlFor="name">Ime i prezime takmicara</Form.Label>
            <Form.Control
              id="contenderName"
              type="text"
              onChange={(e) => handleFieldChange(e)}
            />
            <Form.Label>Datum rodjena</Form.Label>
            <Form.Control
              rows={3}
              id="dateOfBirth"
              type="date"
              onChange={(e) => handleFieldChange(e)}
            />
            <Form.Label>Broj osvojenih medalja</Form.Label>
            <Form.Control
              id="numOfMedals"
              type="number"
              onChange={(e) => handleFieldChange(e)}
            />

            <Form.Label>Drzava takmicara</Form.Label>
            <Form.Control
              as="select"
              id="countryId"
              onChange={(e) => handleFieldChange(e)}
            >
              <option></option>
              {data?.map((country) => {
                return (
                  <option key={country.id} value={country.id}>
                    {country.countryName}, {country.tag}
                  </option>
                );
              })}
            </Form.Control>

            <Button
              style={{ marginTop: "25px" }}
              onClick={() => addContender(fields)}
            >
              Add
            </Button>
          </Form>
        </Col>
        <Col></Col>
      </Row>
    </> */
}
