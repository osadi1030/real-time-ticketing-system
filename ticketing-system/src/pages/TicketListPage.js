import React from 'react';

function TicketListPage() {
    return (
        <div className="ticket-list-page">
            <h2>Available Tickets</h2>
            <div className="ticket-card">
                <h3>Event Name</h3>
                <p>Price: $50</p>
                <button>Buy Ticket</button>
            </div>
            {/* Repeat for more tickets */}
        </div>
    );
}

export default TicketListPage;
