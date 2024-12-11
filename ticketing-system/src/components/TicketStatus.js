import React, { useState, useEffect } from 'react';
import api from '../api';

function TicketStatus() {
    const [tickets, setTickets] = useState([]);

    useEffect(() => {
        const fetchTickets = async () => {
            try {
                const response = await api.get('/tickets/all');
                setTickets(response.data);
            } catch (error) {
                console.error('Failed to fetch tickets:', error);
            }
        };
        fetchTickets();
    }, []);

    return (
        <div>
            <h2>Ticket Status</h2>
            <ul>
                {tickets.map((ticket) => (
                    <li key={ticket.id}>
                        Event ID: {ticket.eventId}, Price: {ticket.price}, Sold: {ticket.sold.toString()}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default TicketStatus;
