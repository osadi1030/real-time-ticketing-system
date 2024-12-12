import React, { useState } from 'react';

export default function LoginPage() {
  const [formData, setFormData] = useState({
    totalTickets: '',
    ticketReleaseRate: '',
    customerRetrievalRate: '',
    maxTicketCapacity: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('http://localhost:8080/start', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          totalTickets: parseInt(formData.totalTickets, 10),
          ticketReleaseRate: parseInt(formData.ticketReleaseRate, 10),
          customerRetrievalRate: parseInt(formData.customerRetrievalRate, 10),
          maxTicketCapacity: parseInt(formData.maxTicketCapacity, 10),
        }),
      });
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const result = await response.json();
      console.log('Response:', result);
    } catch (error) {
      console.error('Error:', error);
    }
  };

  return (
    <div className="login-page">
      <h2>System</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          name="totalTickets"
          placeholder="Enter total tickets"
          value={formData.totalTickets}
          onChange={handleChange}
        />
        <input
          type="number"
          name="ticketReleaseRate"
          placeholder="Enter ticket release rate"
          value={formData.ticketReleaseRate}
          onChange={handleChange}
        />
        <input
          type="number"
          name="customerRetrievalRate"
          placeholder="Enter customer retrieval rate"
          value={formData.customerRetrievalRate}
          onChange={handleChange}
        />
        <input
          type="number"
          name="maxTicketCapacity"
          placeholder="Enter maximum ticket capacity"
          value={formData.maxTicketCapacity}
          onChange={handleChange}
        />
        <button type="submit">Start</button>
      </form>
    </div>
  );
}
