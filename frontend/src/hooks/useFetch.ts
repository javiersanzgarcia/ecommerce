import { useEffect, useState } from 'react';

const useFetch = (url: string) => {
  const [data, setData] = useState<string | null>(null);
  const [loading, setLoading] = useState<boolean | null>(null);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    setLoading(true);
    setError(null);
    setData(null);

    const fetchData = async () => {
      try {
        const response = await fetch(url);
        const data = await response.json();
        setLoading(false);
        setData(data);
      } catch (error) {
        setError('Error fetching data');
        setLoading(false);
        console.error('useFetch error:', error);
      }
    };
    fetchData();
  }, [url]);

  return { data, loading, error };
};

export default useFetch;
