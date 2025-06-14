import useFetch from '@/hooks/useFetch';
import { API } from '@/lib/constants';

const ProductList = () => {
  const { data, loading, error } = useFetch(API.PRODUCTS);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <>
      <div>ProductList...</div>
      <div>{JSON.stringify(data)}</div>
    </>
  );
};

export default ProductList;
