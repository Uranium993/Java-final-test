import "./App.css";
import Games from "./components/Games";
import { Routes, Route, Link, Navigate } from "react-router-dom";
import NewGame from "./components/NewGame";
import { Navbar, Button, Container } from "react-bootstrap";
import Nav from "react-bootstrap/Nav";
import NotFound from "./components/NotFound";
import { logout } from "./apis/auth";
import Home from "./components/Home";
import Login from "./components/Login/Login";

function App() {
  const admin = window.localStorage["role"] === "ROLE_ADMIN";
  const user = window.localStorage["role"] === "ROLE_KORISNIK";
  // const admin = "ROLE_ADMIN";
  // const user = undefined;

  if (admin) {
    return (
      <>
        <Navbar expand bg="dark" variant="dark">
          <Navbar.Brand as={Link} to="/">
            Winery JWD Test
          </Navbar.Brand>

          <Nav>
            <Nav.Link as={Link} to="/games ">
              Utakmice
            </Nav.Link>
            <Nav.Link as={Link} to="/games/add">
              Kreiraj utakmicu
            </Nav.Link>
            <Button onClick={() => logout()}>Logout</Button>:
          </Nav>
        </Navbar>
        <Container style={{ paddingTop: "10px" }}>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Navigate replace to="/" />} />
            <Route path="/games" element={<Games />} />
            <Route path="/games/add" element={<NewGame />} />
            <Route path="*" element={<NotFound />} />
          </Routes>
        </Container>
      </>
    );
  } else if (user) {
    return (
      <>
        <Navbar expand bg="dark" variant="dark">
          <Navbar.Brand as={Link} to="/">
            Winery JWD Test
          </Navbar.Brand>

          <Nav>
            <Nav.Link as={Link} to="/games ">
              Wines
            </Nav.Link>
            <Button onClick={() => logout()}>Logout</Button>:
          </Nav>
        </Navbar>
        <Container style={{ paddingTop: "10px" }}>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Navigate replace to="/" />} />
            <Route path="/games" element={<Games />} />
            <Route path="*" element={<NotFound />} />
          </Routes>
        </Container>
      </>
    );
  } else {
    return (
      <>
        <Navbar expand bg="dark" variant="dark">
          <Navbar.Brand as={Link} to="/">
            Winery JWD Test
          </Navbar.Brand>
          <Nav>
            <Nav.Link as={Link} to="/login">
              Login
            </Nav.Link>
          </Nav>
        </Navbar>
        <Container style={{ paddingTop: "10px" }}>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="*" element={<Navigate replace to="/login" />} />
          </Routes>
        </Container>
      </>
    );
  }

  // return (
  //   <div className="App">
  //     <Navbar expand bg="dark" variant="dark">
  //       <Navbar.Brand as={Link} to="/">
  //         Welcome to JWD Winery
  //       </Navbar.Brand>
  //       <Nav>
  //         <Nav.Link as={Link} to="/wines">
  //           Wines
  //         </Nav.Link>
  //         <Button>Log out</Button>
  //       </Nav>
  //     </Navbar>
  //     <Routes>
  //       <Route path="/wines" element={<Wines />} />
  //       <Route path="/wines AddContender" element={ AddContender />} />
  //     </Routes>
  //   </div>
  // );
}

export default App;
