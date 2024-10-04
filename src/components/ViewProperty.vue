<template>
  <q-dialog v-model="dialog" persistent>
    <q-card class="q-mb-sm q-pa-sm small-card row no-wrap">
      <div class="col-auto q-pa-md">
        <!-- Carousel de imágenes -->
        <q-carousel v-model="currentImageIndex" animated infinite navigation-arrows>
          <q-carousel-slide v-for="(img, index) in property.images" :key="index" :name="index" :img-src="img"
            class="small-image" />
        </q-carousel>
        <!-- Miniaturas -->
        <div class="row q-gutter-sm q-mt-md">
          <q-img v-for="(img, index) in property.images" :key="index" :src="img" :alt="property.title"
            class="thumbnail col-auto" @click="currentImageIndex = index" />
        </div>
      </div>

      <q-card-section class="q-pa-sm col section">
        <div class="text-subtitle2">{{ property.title }}</div>
        <div class="text-body2">{{ property.price }}</div>
        <br>
        <q-chip class="q-pa-sm" dense icon="place" :label="property.location" />
        <br>
        <q-chip dense color="green" icon="verified" label="Verificado" />
        <q-chip dense color="green" icon="check_circle" label="Disponible" v-if="property.available" />
        <br>
        <q-btn flat label="Cerrar" color="red" @click="closeDialog" />
      </q-card-section>
    </q-card>
  </q-dialog>
</template>

<script setup>
import { ref, onMounted } from 'vue'
const dialog = ref(false)
const currentImageIndex = ref(0)
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
    currentImageIndex.value = 0;
    console.log(images)
  }
})
function openDialog() {
  dialog.value = true;
}
const closeDialog = () => {
  dialog.value = false;
}
defineExpose({ openDialog });
</script>

<style scoped>
.small-card {
  width: 100%;
  display: flex;
}

.thumbnail {
  width: 80px;
  height: 50px;
  object-fit: cover;
  cursor: pointer;
  border-radius: 5px;
  border: 2px solid transparent;
  transition: border 0.2s;
}

.thumbnail:hover {
  border-color: blue;
}

.section {
  display: flex;
  flex-direction: column;
}

.small-image {
  width: 300px;
  height: 190px;
  object-fit: cover;
  border-radius: 10px;
}


.text-subtitle2 {
  font-size: 14px;
  font-weight: bold;
}

.text-body2 {
  font-size: 18px;
  color: red;
}

.q-chip {
  margin-top: 4px;
}

.q-card {
  min-width: 800px !important;
  min-height: 210px;
}
</style>
