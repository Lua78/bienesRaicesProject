<template>
  <div class="center">
    <q-card class="q-mb-sm col no-wrap">
      <q-img src="/assets/logo.png" class="small-image col-auto q-pa-md" />
      <q-card-section style="width: 100%;">
        <q-input class="my-input" label="Nombre de usuario o correo" v-model="user" />
        <q-input label="Contraseña" v-model="pass" type="password" />
        <a href="/login/recovery">¿Olvidó su contraseña?</a>
        <div class="q-mt-md" style="padding: 0%;">
          <q-btn icon="check" class="rounded-borders" label="Iniciar sesión" color="green" @click="login" />
        </div>
      </q-card-section>
    </q-card>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { api } from 'src/boot/axios';

const user = ref('');
const pass = ref('');

const login = async () => {
  if (!user.value || !pass.value) {
    console.error('El nombre de usuario y la contraseña son requeridos');
    return;
  }

  try {
    const response = await api.post('/auth/login', {
      username: user.value,
      password: pass.value
    });
    if (response.data && response.data.body.token) {
      // Guardar el token en el localStorage
      localStorage.setItem('authToken', response.data.body.token);
      console.log('Token guardado:', response.data.authToken);

      // Redirigir a otra página (ejemplo)
      window.location.href = '/admin';  // Ajusta según la ruta que necesitess
    } else {
      s
      console.error('No se recibió token de autenticación');
    }
  } catch (error) {
    console.error('Error al intentar iniciar sesión:', error);
  }
}
</script>

<style scoped>
.small-card {
  width: auto;
  display: flex;
  max-height: 200px;
  flex-direction: column;
  border: solid green 1px;
}

.small-image {
  width: 300px;
  height: 240px;
  object-fit: cover;
  border-radius: 25px;
}

.q-card-section {
  width: 100% !important;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.q-card {
  display: flex;
  flex-direction: column;
  align-items: center;
  min-width: 400px;
  border: solid rgb(40, 165, 40) 1px;
}

.q-input {
  width: 100%;
}

.center {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 50px;
}
</style>
