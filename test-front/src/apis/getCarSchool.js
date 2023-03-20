import api from "./api";

export const getSchools = async (setSchools) => {
  try {
    const res = await api.get("/auto-skole");
    setSchools(res.data);
  } catch (error) {
    console.log(error.message);
  }
};
