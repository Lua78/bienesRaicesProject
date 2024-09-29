<template>
  <q-page>
    <q-page-container>
      <q-list>
        <property-item v-for="property in properties" :key="property.id" :property="property" />
      </q-list>
    </q-page-container>

  </q-page>
</template>

<script setup>

import { ref } from 'vue'
import PropertyItem from './PropertyItem.vue'
    const properties = ref([
      {
        id: 1,
        title: 'Casa de con dos cuartos y un baño',
        price: 'C$ 12000.00',
        location: 'Las Colinas, Managua',
        available: true,
        image: 'link_to_image.jpg'
      },
      {
        id: 2,
        title: 'Apartamentos disponibles',
        price: 'C$ 1200.00',
        location: 'Metrocentro, Managua',
        available: true,
        image: 'link_to_image.jpg'
      },
      // Agrega más propiedades aquí...
    ])

</script>
