import api from "./api";

export const addGame = async (body) => {
  // body = {
  //   ...body,
  //   wineryId: 1,
  // };
  console.log(body);

  try {
    const res = await api.post("/utakmice", body);
    return res;
  } catch (error) {
    console.log(error.message);
  }
};
