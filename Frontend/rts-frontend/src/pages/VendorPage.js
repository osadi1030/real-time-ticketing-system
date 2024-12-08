import React, { useState } from "react";
import "../styles/VendorPage.css";

function VendorPage() {
    const [eventName, setEventName] = useState("");
    const [ticketQuantity, setTicketQuantity] = useState("");
    const [ticketPrice, setTicketPrice] = useState("");

    // Handle form submission
    const handleReleaseTicket = () => {
        // Example: You can make an API call here to release tickets (integrate later with backend)
        console.log("Ticket Released: ", {
            eventName,
            ticketQuantity,
            ticketPrice,
        });

        // Reset form
        setEventName("");
        setTicketQuantity("");
        setTicketPrice("");
    };
    return (
        <div>
            <h2>Vendor Dashboard</h2>
            <h3>Release Tickets</h3>
            <p>Manage ticket releases here.</p>
            <form>
                <div>
                    <label>Event Name:</label>
                    <input
                        type="text"
                        value={eventName}
                        onChange={(e) => setEventName(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Ticket Quantity:</label>
                    <input
                        type="number"
                        value={ticketQuantity}
                        onChange={(e) => setTicketQuantity(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Ticket Price ($):</label>
                    <input
                        type="number"
                        value={ticketPrice}
                        onChange={(e) => setTicketPrice(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <button type="button" onClick={handleReleaseTicket}>
                        Release Ticket
                    </button>
                </div>
            </form>

        </div>
    );
}

export default VendorPage;
