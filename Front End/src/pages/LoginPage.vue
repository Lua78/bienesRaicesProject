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
import { ref } from 'vue'

const user = ref('')
const pass = ref('')

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
