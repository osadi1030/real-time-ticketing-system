import React, { useState } from "react";
import "../styles/CustomerPage.css";

function CustomerPage() {
    const [tickets, setTickets] = useState([
        { id: 1, eventName: "Concert A", available: 100, price: 20 },
        { id: 2, eventName: "Concert B", available: 50, price: 30 },
        { id: 3, eventName: "Play C", available: 30, price: 15 },
    ]);

    const handleBuyTicket = (ticketId) => {
        // Example: Handle ticket purchase logic (e.g., API call, WebSocket update)
        alert(`Purchased ticket for event ${ticketId}`);
    };
    return (
        <div>
            <h2>Customer Dashboard</h2>
            <h3>Available Tickets</h3>
            <p>Purchase tickets here.</p>
            <div>
                {tickets.map((ticket) => (
                    <div key={ticket.id} style={ticket.available <= 0 ? {opacity: 0.5} : {}}>
                        <h4>{ticket.eventName}</h4>
                        <p>Price: ${ticket.price}</p>
                        <p>Available: {ticket.available}</p>
                        <button
                            disabled={ticket.available <= 0}
                            onClick={() => handleBuyTicket(ticket.id)}
                        >
                            Buy Ticket
                        </button>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default CustomerPage;
