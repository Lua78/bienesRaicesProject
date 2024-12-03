<template>
  <q-page>
    <q-list>
      <property-item v-for="property in properties" :key="property.idProperty" :property="property" />
    </q-list>

  </q-page>
</template>

<script setup>
import { ref, onMounted, watch } from 'vue'
import { api } from 'boot/axios' // Importa la instancia de axios configurada

import PropertyItem from './PropertyItem.vue'
const props = defineProps({
  searchQuery: String,
  type: String,
  state: String
})

const properties = ref([])

console.log(props.searchQuery, props.filterBym, props.priceRange)

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
// Función para filtrar las propiedades
const filterProperties = async () => {
  let params = "";

  if (typeof props.searchQuery === "string" && props.searchQuery.trim() !== "" && typeof props.searchQuery === "string") {
    params += `?search=${encodeURIComponent(props.searchQuery)}`;
  }

  if (props.state !== null && props.state !== undefined && typeof props.state === "string") {
    params += (params ? "&" : "?") + `state=${encodeURIComponent(props.state)}`;
  }
  if (props.type !== null && props.type !== undefined && typeof props.type === "string") {
    params += (params ? "&" : "?") + `type=${encodeURIComponent(props.type)}`;
  }
  const response = await api.get('/properties' + params)
  // Asignamos los datos a la variable reactiva
  properties.value = response.data.body
  console.log("URL con parámetros:", params);
};


// Observadores para detectar cambios en las props y volver a filtrar
watch(() => props.searchQuery, filterProperties)
watch(() => props.type, filterProperties)
watch(() => props.state, filterProperties)
</script>
