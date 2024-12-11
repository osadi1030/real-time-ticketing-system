import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080/api', // Base URL for your backend
});

// Add a token to headers if available
api.interceptors.request.use((config) => {
    const token = localStorage.getItem('token'); // Assume token is stored in localStorage
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
});

export default api;
