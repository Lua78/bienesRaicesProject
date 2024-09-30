<template>
  <q-layout view="hHh lpR fFf">
    <q-header class="header text-white q-pa-md" height-hint="98">
    </q-header>
    <q-drawer show-if-above v-model="rightDrawerOpen" side="right" bordered>
      <div class="q-pa-md">
        <img src="/assets/logo.png" class="img-acoplada">

        <!-- Lista de ítems -->
        <q-list>

          <!-- Ítem 1: Agregar una propiedad -->
          <q-item clickable v-ripple class="item-clickable">
            <q-item-section avatar>
              <q-icon name="home" />
            </q-item-section>
            <q-item-section>
              Agregar una propiedad
            </q-item-section>
          </q-item>

          <!-- Ítem 2: Editar categorías -->
          <q-item clickable v-ripple class="item-clickable">
            <q-item-section avatar>
              <q-icon name="category" />
            </q-item-section>
            <q-item-section>
              Editar categorías
            </q-item-section>
          </q-item>

          <!-- Ítem 3: Editar perfil de contacto -->
          <q-item clickable v-ripple class="item-clickable">
            <q-item-section avatar>
              <q-icon name="person" />
            </q-item-section>
            <q-item-section>
              Editar perfil de contacto
            </q-item-section>
          </q-item>

        </q-list>
      </div>
    </q-drawer>


    <q-page-container>
      <router-view />
    </q-page-container>

  </q-layout>
</template>

<script setup>
import { ref } from 'vue'

const leftDrawerOpen = ref(false)
const rightDrawerOpen = ref(false)
const searchQuery = ref('')
const priceRange = ref([3000, 40000])
const onlyAvailable = ref(false)
const filterBy = ref({
  icon: "home",
  name: "Todos"
})

const options = [
  {
    icon: "home",
    name: "Todos"
  },
  {
    icon: "home",
    name: "Casas"
  },
  {
    icon: "store",
    name: "Bodegas"
  },
  {
    icon: "apartment",
    name: "Departamentos"
  }
]



</script>

<style scoped>
.header {
  background-color: #1ABA1A;
}

.img-acoplada {
  width: 100%;
  height: 200px;
  object-fit: cover;
  border-radius: 10px;
}

.inputSearch {
  padding-left: 25px;
  border-radius: 8px;
}

.mw {
  min-width: 300px;
}

.maw {
  max-width: 284px;
}

.my-input {
  color: black;
  background-color: white;
  border: none;
  border-radius: 10px;
}

.my-search {
  display: flex;
  justify-content: space-between;
}

.mh2 {
  max-height: 45px;
}
.item-clickable {
  background-color: #f0f0f0; /* Fondo gris claro */
  border-radius: 10px; /* Bordes redondeados */
  margin-bottom: 10px; /* Espacio entre los ítems */
}

.item-clickable:hover {
  background-color: #e0e0e0; /* Cambia el color cuando se pasa el mouse */
}
</style>
