import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080/api",
});
api.interceptors.request.use(function presretac(config) {
  const jwt = window.localStorage["jwt"];
  if (jwt) {
    config.headers["Authorization"] = "Bearer " + jwt;
  }
  return config;
});
export default api;
