import React, { useState } from 'react';

function RegisterPage() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [role, setRole] = useState('User');

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log({ email, password, role });
        // Add registration functionality here
    };

    return (
        <div className="register-page">
            <h2>Register</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="email"
                    placeholder="Email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <select value={role} onChange={(e) => setRole(e.target.value)}>
                    <option value="User">User</option>
                    <option value="Vendor">Vendor</option>
                </select>
                <button type="submit">Register</button>
            </form>
        </div>
    );
}

export default RegisterPage;
