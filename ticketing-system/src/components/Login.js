import React, { useState } from 'react';
import api from '../api';

function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await api.post('/users/login', { email, password });
            localStorage.setItem('token', response.data.token); // Save token for authenticated requests
            alert('Login Successful!');
        } catch (error) {
            alert('Login Failed!');
            console.error(error);
        }
    };

    return (
        <form onSubmit={handleLogin}>
            <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} required />
            <input type="password" placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} required />
            <button type="submit">Login</button>
        </form>
    );
}

export default Login;
