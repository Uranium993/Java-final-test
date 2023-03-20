import { useState } from "react";
import useFetchData from "../apis/useFetchData";
import { Button, Table, Form } from "react-bootstrap";
import { deleteData } from "../apis/deleteData";
import { addGoal } from "../apis/addGoal";
import { useNavigate } from "react-router-dom";
import { useFormFields } from "../utils/useFormFields";

const Games = () => {
  const navigate = useNavigate();
  const [checked, setChecked] = useState(false);
  const [fields, handleFieldChange] = useFormFields();
  const [page, setPage] = useState(0);

  // useEffect(() => {
  //   getSchools(setSchools);
  // }, [schools]);

  if (checked) {
  }

  const { data, loading, onError, setInvalidateFetch, totalPages, setParams } =
    useFetchData(`/utakmice`, page);

  const {
    data: teams,
    //  loading: schoolLoading,
    //  onError: schoolOn,
    setInvalidateFetch: schoolSetInvalidate,
    //totalPages,
    //setParams,
  } = useFetchData(`/reprezentacije`, page);

  const goToAdd = () => {
    navigate(`/games/add`);
  };

  const handleReservation = (line) => {
    addGoal(line, setInvalidateFetch);
  };

  const handleEdit = () => {
    return;
  };

  const renderLines = () => {
    return data?.map((game) => {
      return (
        <tr key={game.id}>
          <td>{game.teamNameA}</td>
          <td>{game.teamNameB}</td>
          <td>{game.goalsA}</td>
          <td>{game.goalsB}</td>

          {/* <td>
            {contender.countryName}, {contender.countryTag}
          </td> */}

          <td>
            <Button onClick={() => addGoal(game.id, "A", setInvalidateFetch)}>
              A + 1
            </Button>
          </td>
          <td>
            <Button onClick={() => addGoal(game.id, "B", setInvalidateFetch)}>
              B + 1
            </Button>
          </td>
          <td>
            <Button variant="warning" onClick={() => handleEdit(game)}>
              Edit
            </Button>
          </td>
          <td>
            <Button
              variant="danger"
              onClick={() => deleteData(game.id, setInvalidateFetch)}
            >
              Delete
            </Button>
          </td>
        </tr>
      );
    });
  };

  return (
    <div>
      <h1>Utakmice</h1>
      <Button onClick={() => goToAdd()}>ADD</Button>
      <div>
        <br />

        <Table style={{ marginTop: 5 }}>
          <thead className="thead-dark">
            <tr>
              <th>Team A</th>
              <th>Team B</th>
              <th>Golovi A</th>
              <th>Golovi B</th>
            </tr>
          </thead>
          <tbody>
            {loading ? (
              <tr>
                <th> Loading </th>
              </tr>
            ) : onError ? (
              <tr>
                <th> {onError} </th>
              </tr>
            ) : (
              renderLines()
            )}
          </tbody>
        </Table>
      </div>
      <Button
        disabled={page == 0}
        onClick={() => setPage(page - 1)}
        className="mr-2"
      >
        PREVIOUS
      </Button>
      <Button
        disabled={page == totalPages - 1}
        onClick={() => setPage(page + 1)}
      >
        NEXT
      </Button>
      <form>
        <br />

        <label>Search</label>
        <br />
        <input
          type="checkbox"
          checked={checked}
          onChange={() => setChecked((prev) => !prev)}
        />
      </form>
      {checked ? (
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
            id="teamAId"
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
            id="teamBId"
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

          <Button
            style={{ marginTop: "25px" }}
            onClick={() => setParams(fields)}
          >
            Search
          </Button>
        </Form>
      ) : null}
    </div>
  );
};

export default Games;
