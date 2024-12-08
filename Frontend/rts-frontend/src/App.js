import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import VendorPage from "./pages/VendorPage";
import CustomerPage from "./pages/CustomerPage";
import "./styles/Nav.css";
function App() {
  return (
      <Router>
          <div>
              <h1>Welcome to the Ticketing System</h1>
          </div>
        <div>
            <nav>
                <ul>
                    <li>
                        <Link to="/vendor">Vendor</Link>
                    </li>
                    <li>
                        <Link to="/customer">Customer</Link>
                    </li>
                </ul>
            </nav>

            <Routes>
                <Route path="/vendor" element={<VendorPage />} />
                <Route path="/customer" element={<CustomerPage />} />
            </Routes>
        </div>
    </Router>
  );
}

export default App;
