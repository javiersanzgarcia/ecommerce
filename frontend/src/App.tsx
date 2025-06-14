import "./App.css";
import { BrowserRouter, Route, Routes } from "react-router";
import ProductPage from "@/pages/ProductPage";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route index element={<ProductPage />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
