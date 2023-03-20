import { useEffect, useState, useReducer } from "react";
import api from "./api";

const useFetchData = (url, pageNum) => {
  const [data, setData] = useState();
  const [totalPages, setTotalPages] = useState();
  const [loading, setLoading] = useState(true);
  const [onError, setOnError] = useState();
  const [invalidate, setInvalidateFetch] = useState(false);
  const [params, setParams] = useState();
  // const initialState = {
  //   loading: true,
  //   totalPages: 0,
  //   onError: "",
  //   data: [],
  //   invalidate,
  // };

  // const reducer = (state, action) => {
  //   switch (action.type) {
  //     case "FETCH_SUCCESS":
  //       return {
  //         ...state,
  //         loading: false,
  //         data: action.payload,
  //         error: "",
  //       };
  //     case "FETCH_ERROR":
  //       return {
  //         ...state,
  //         loading: false,
  //         data: [],
  //         error: "Something went wrong!",
  //       };
  //     case "SET_TOTAL_PAGES":
  //       return {
  //         ...state,

  //         loading: false,
  //         totalPages: action.payload,
  //         error: "Something went wrong!",
  //       };
  //     case "INVALIDATE":
  //       return {
  //         ...state,
  //         invalidate: !state.invalidate,
  //         data: action.payload,
  //         error: "",
  //       };
  //     default:
  //       return state;
  //   }
  // };
  // const [state, dispatch] = useReducer(reducer, initialState);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await api.get(url, {
          params: {
            ...params,
            pageNo: pageNum,
          },
        });
        //dispatch({ type: "FETCH_SUCCESS", payload: res.data });
        setData(res.data);
        // dispatch({
        // type: "SET_TOTAL_PAGES",
        // payload: res.headers["total-pages"],
        // });

        setTotalPages(res.headers["total-pages"]);
      } catch (error) {
        console.error(error);
        //dispatch({ type: "FETCH_ERROR", payload: error.message });

        setOnError(error.message);
      }
      setLoading(false);
    };

    fetchData();
  }, [url, invalidate, pageNum, params]);

  return {
    // data: state.data,
    data,
    setInvalidateFetch,
    setParams,
    loading,
    onError,
    totalPages,
  };
};

export default useFetchData;
