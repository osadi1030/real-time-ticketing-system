import React, { useState } from 'react';
import api from '../api';

function ConfigurationForm() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [role, setRole] = useState('User');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await api.post('/users/register', {
                email,
                password,
                role,
            });
            alert('Registration Successful!');
            console.log(response.data);
        } catch (error) {
            alert('Registration Failed!');
            console.error(error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} required />
            <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} required />
            <select value={role} onChange={(e) => setRole(e.target.value)}>
                <option value="User">User</option>
                <option value="Vendor">Vendor</option>
            </select>
            <button type="submit">Register</button>
        </form>
    );
}

export default ConfigurationForm;
