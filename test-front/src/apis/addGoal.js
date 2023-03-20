import api from "./api";
export const addGoal = async (id, teamID, setInvalidateFetch) => {
  console.log(id);
  try {
    await api.put(`utakmice/${id}/${teamID}`);
    await setInvalidateFetch((prev) => !prev);
  } catch (error) {
    console.log(error);
  }
};
