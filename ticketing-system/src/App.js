import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import TicketListPage from './pages/TicketListPage';
import LoginPage from './pages/LoginPage';
import Header from './components/Header';

import './App.css';

function App() {
  return (
      <Router>
        <div className="App">
          <Header />
          <Routes>
            <Route path="/" element={<TicketListPage />} />
            <Route path="/login" element={<LoginPage />} />
            
          </Routes>
        </div>
      </Router>
  );
}

export default App;
