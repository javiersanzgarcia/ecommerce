import useFetch from "@/hooks/useFetch";
import { API } from "@/lib/constants";

const ProductList = () => {
  const fetchData = useFetch(API.PRODUCTS);

  return (
    <>
      <div>ProductList...</div>
      <div>{JSON.stringify(fetchData)}</div>
    </>
  );
};

export default ProductList;
