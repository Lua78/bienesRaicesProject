import { boot } from "quasar/wrappers";
import axios from "axios";

const api = axios.create({ baseURL: "http://localhost:8080" });
api.interceptors.request.use(
  (config) => {
    // Obtén el token del sessionStorage
    const token = localStorage.getItem("authToken"); // Ajusta la clave si es necesario
    console.log(token);
    // Si el token existe, lo agrega a los encabezados de la solicitud
    if (token) {
      config.headers["Authorization"] = token;
    }

    // Devuelve la configuración de la solicitud modificada
    return config;
  },
  (error) => {
    // Si ocurre un error en la solicitud, lo lanzamos para que pueda ser manejado
    return Promise.reject(error);
  }
);

export default boot(({ app }) => {
  // Asigna Axios a la propiedad global $axios para usar en la API de opciones de Vue
  app.config.globalProperties.$axios = axios;

  // Asigna la instancia personalizada de Axios a la propiedad global $api
  app.config.globalProperties.$api = api;
});

export { api };
