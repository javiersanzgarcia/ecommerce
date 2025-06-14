const useFetch = async (url: string) => {
  try {
    const response = await fetch("http://localhost:8080/hexagonal/products");
    const data = await response.json();
    return data;
  } catch (error) {
    console.error(error);
  }
};

export default useFetch;
