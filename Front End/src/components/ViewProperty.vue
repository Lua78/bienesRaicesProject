<template>
  <q-dialog v-model="dialog" persistent>
    <q-card class="q-mb-sm q-pa-sm small-card row no-wrap">
      <div class="col-auto q-pa-md">
        <!-- Carousel de imágenes -->
        <q-carousel v-model="currentImageIndex" animated infinite navigation-arrows>
          <q-carousel-slide v-for="(img, index) in property.files" :key="index" :name="index" :img-src="img"
            class="small-image" />
        </q-carousel>
        <!-- Miniaturas -->
        <div class="row q-gutter-sm q-mt-md">
          <q-img v-for="(img, index) in property.files" :key="index" :src="img" :alt="property.title"
            class="thumbnail col-auto" @click="currentImageIndex = index" />
        </div>
      </div>

      <q-card-section class="q-pa-sm col section">
        <div class="text-subtitle2">{{ property.name }}</div>
        <div class="text-body3">{{ property.details }}</div>
        <div class="text-body2">{{ property.price }}</div>
        <br>
        <q-chip class="q-pa-sm" dense icon="place" :label="property.address" />
        <br>

        <q-chip dense color="green" icon="check_circle" label="Disponible" v-if="property.active" />

        <!-- Si la propiedad es true, muestra un chip verde; si es false, muestra un chip rojo -->

        <q-chip dense color="green" icon="check_circle" label="Jardín" v-if="property.garden" />
        <q-chip dense color="red" icon="cancel" label="Jardín" v-else />

        <q-chip dense color="green" icon="check_circle" label="Patio" v-if="property.yard" />
        <q-chip dense color="red" icon="cancel" label="Patio" v-else />

        <q-chip dense color="green" icon="check_circle" label="Sala de estar" v-if="property.livingRoom" />
        <q-chip dense color="red" icon="cancel" label="Sala de estar" v-else />

        <q-chip dense color="green" icon="check_circle" label="Cocina" v-if="property.kitchen" />
        <q-chip dense color="red" icon="cancel" label="Cocina" v-else />

        <q-chip dense color="green" icon="check_circle" label="Comedor" v-if="property.dinningRoom" />
        <q-chip dense color="red" icon="cancel" label="Comedor" v-else />

        <q-chip dense color="green" icon="check_circle" label="Cuarto de servicio" v-if="property.serviceRoom" />
        <q-chip dense color="red" icon="cancel" label="Cuarto de servicio" v-else />

        <q-chip dense color="green" icon="check_circle" label="Cuarto de lavandería" v-if="property.laundryRoom" />
        <q-chip dense color="red" icon="cancel" label="Cuarto de lavandería" v-else />

        <q-chip dense color="green" icon="check_circle" label="Seguridad privada" v-if="property.privateSecurity" />
        <q-chip dense color="red" icon="cancel" label="Seguridad privada" v-else />

        <q-chip dense color="green" icon="check_circle" label="Piscina" v-if="property.pool" />
        <q-chip dense color="red" icon="cancel" label="Piscina" v-else />

        <q-chip dense color="green" icon="check_circle" label="Estudio" v-if="property.studio" />
        <q-chip dense color="red" icon="cancel" label="Estudio" v-else />

        <q-chip dense color="green" icon="check_circle" label="Garaje" v-if="property.garage" />
        <q-chip dense color="red" icon="cancel" label="Garaje" v-else />

        <q-chip dense color="green" icon="check_circle" label="Terraza" v-if="property.terrace" />
        <q-chip dense color="red" icon="cancel" label="Terraza" v-else />

        <q-chip dense color="green" icon="check_circle" label="Voltaje 220V" v-if="property.voltage220" />
        <q-chip dense color="red" icon="cancel" label="Voltaje 220V" v-else />

        <q-chip dense color="green" icon="check_circle" label="Escuelas cercanas" v-if="property.schools" />
        <q-chip dense color="red" icon="cancel" label="Escuelas cercanas" v-else />

        <q-chip dense color="green" icon="check_circle" label="Tráfico cercano" v-if="property.nearbyTraffic" />
        <q-chip dense color="red" icon="cancel" label="Tráfico cercano" v-else />

        <q-chip dense color="green" icon="check_circle" label="Área de construcción" v-if="property.constructionArea" />
        <q-chip dense color="red" icon="cancel" label="Área de construcción" v-else />

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
      Object
    },
    required: true
  }
})
const image = ref('/assets/defaultHouse.webp')
onMounted(() => {
  const images = props.property.files
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
.text-body3 {
  font-size: 12px;
  color: black;
}

.q-chip {
  margin-top: 4px;
}

.q-card {
  min-width: 800px !important;
  min-height: 210px;
}
</style>
