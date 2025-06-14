import "./App.css";
import {
  BrowserRouter,
  useSearchParams,
  Link,
  Route,
  Routes,
} from "react-router";
import About from "@/pages/About";
import { useCounterStore } from "./store/counter";
import { Button } from "./components/ui/button";

const Home = () => {
  const [searchParams] = useSearchParams();
  const { count, increment, decrement, reset } = useCounterStore();

  return (
    <>
      {searchParams.toString() !== "" && (
        <div>Home page with query {searchParams.toString()}...</div>
      )}

      <Link to="/about">Go to about!</Link>
      <div className="bg-amber-500 mb-5">
        <p className="text-white">HELLO WORLD</p>
      </div>
      <div>
        <h1>Count: {count}</h1>
        <Button onClick={increment}>Increment</Button>
        <Button variant={"secondary"} onClick={decrement}>
          Decrement
        </Button>
        <Button onClick={reset}>Reset</Button>
      </div>
    </>
  );
};

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route index element={<Home />} />
          <Route path="about" element={<About />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
