<template>
  <q-page>
    <q-list>
      <property-item v-for="property in properties" :key="property.idProperty" :property="property" />
    </q-list>

  </q-page>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { api } from 'boot/axios' // Importa la instancia de axios configurada

import PropertyItem from './PropertyItem.vue'

// Declaramos una variable reactiva para las propiedades
const properties = ref([])

// Usamos onMounted para cargar las propiedades cuando el componente se monta
onMounted(async () => {
  try {
    // Realizamos la solicitud GET
    const response = await api.get('/properties')
    // Asignamos los datos a la variable reactiva
    properties.value = response.data.body // Asegúrate de que la respuesta tenga las propiedades en "data"
  } catch (error) {
    console.error('Error al obtener las propiedades:', error)
  }
})
</script>
