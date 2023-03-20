import api from "./api";

export const deleteData = async (id, setInvalidateFetch) => {
  try {
    const res = await api.delete(`/utakmice/${id}`);
    await setInvalidateFetch((prev) => !prev);
    return res;
  } catch (err) {
    console.log(err);
  }
};
