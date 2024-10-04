<template>
  <q-card class="q-mb-sm q-pa-sm small-card row no-wrap">
    <q-img :src="image" :alt="property.title" class="small-image col-auto q-pa-md" />

    <q-card-section class="q-pa-sm col">
      <div class="text-subtitle2">{{ property.title }}</div>
      <div class="text-body2">{{ property.price }}</div>
      <br>
      <q-chip class="q-pa-sm" dense icon="place" :label="property.location" />
      <br>
      <q-chip dense color="green" icon="verified" label="Verificado" />

      <div class="q-mt-md flex justify-between" style="padding: 0%;">
        <q-chip dense color="green" icon="check_circle" label="Disponible" v-if="property.available" />
        <q-btn icon="visibility" class="rounded-borders" label="Ver" color="primary" @click="onViewClick" />
      </div>
    </q-card-section>
  </q-card>
</template>

<script setup>

import { onMounted, ref } from 'vue';
const props = defineProps({
  property: {
    type: {
      id: Number,
      title: String,
      price: Number,
      location: String,
      type: String,
      available: Boolean,
      images: Array
    },
    required: true
  }
})
const image = ref('/assets/defaultHouse.webp')
onMounted(() => {
  const images = props.property.images
  if (images.length > 0) {
    image.value = images[0];
    console.log(images)
  }
})


</script>

<style scoped>
.small-card {
  width: 100%;
  display: flex;
  max-height: 200px;
  /* Ajusta la altura máxima de la tarjeta */
}

.small-image {
  width: 300px;
  height: 190px;
  /* Ajusta el tamaño de la imagen */
  object-fit: cover;
  /* Asegura que la imagen cubra su espacio correctamente */
  border-radius: 10px;
}

.q-card-section {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  /* Apila los elementos uno encima del otro */
}

.text-subtitle2 {
  font-size: 14px;
  font-weight: bold;
  /* Ajusta el tamaño del título */
}

.text-body2 {
  font-size: 18px;
  color: red;
  /* Ajusta el tamaño del texto del precio */
}

.q-chip {
  margin-top: 4px;
}
</style>
