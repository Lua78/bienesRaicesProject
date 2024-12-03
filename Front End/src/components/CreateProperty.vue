<template>
  <q-dialog v-model="dialog" persistent style="min-width: 500px;">
    <q-card class="q-pa-md aaa" style="width: 500px;">
      <q-card-section>
        <div class="text-h6">Agregar una Propiedad</div>
      </q-card-section>

      <q-form @submit="onSubmit" @reset="onReset" style="min-width: 450px;">
        <!-- Nombre de la propiedad -->
        <q-card-section>
          <q-input v-model="propertyData.name" label="Nombre de la propiedad" filled />
        </q-card-section>
        <q-card-section>
          <q-input v-model="propertyData.details" label="Detalles de la propiedad" filled />
        </q-card-section>
        <!-- Precio -->
        <q-card-section>
          <q-input v-model="propertyData.price" label="Precio" type="number" filled />
        </q-card-section>

        <!-- Tipo de propiedad -->
        <q-card-section>
          <q-select v-model="propertyData.idType" :options="types" label="Tipo de propiedad" filled emit-value
            map-options option-value="idPropertyState" option-label="name" />
        </q-card-section>


        <!-- Dirección -->
        <q-card-section>
          <q-input v-model="propertyData.address" label="Dirección" filled />
        </q-card-section>

        <!-- Estado de la propiedad -->
        <q-card-section>
          <q-select v-model="propertyData.statePropertyId" :options="states" label="Estado de la propiedad" filled
            emit-value map-options option-value="idPropertyState" option-label="name" />
        </q-card-section>



        <!-- Características de la propiedad -->
        <q-card-section>
          <q-toggle v-model="propertyData.garden" label="Jardín" />
          <q-toggle v-model="propertyData.yard" label="Patio" />
          <q-toggle v-model="propertyData.livingRoom" label="Sala de estar" />
          <q-toggle v-model="propertyData.kitchen" label="Cocina" />
          <q-toggle v-model="propertyData.dinningRoom" label="Comedor" />
          <q-toggle v-model="propertyData.serviceRoom" label="Cuarto de servicio" />
          <q-toggle v-model="propertyData.laundryRoom" label="Cuarto de lavandería" />
          <q-toggle v-model="propertyData.privateSecurity" label="Seguridad privada" />
          <q-toggle v-model="propertyData.pool" label="Piscina" />
          <q-toggle v-model="propertyData.studio" label="Estudio" />
          <q-toggle v-model="propertyData.garage" label="Garaje" />
          <q-toggle v-model="propertyData.terrace" label="Terraza" />
          <q-toggle v-model="propertyData.voltage220" label="Voltaje 220V" />
          <q-toggle v-model="propertyData.schools" label="Cercanía a escuelas" />
          <q-toggle v-model="propertyData.nearbyTraffic" label="Cercanía a tráfico" />
          <q-toggle v-model="propertyData.constructionArea" label="Área de construcción" />
        </q-card-section>

        <!-- Subir imágenes -->
        <q-card-section>
          <q-file v-model="images" label="Subir imágenes" filled multiple @added="handleImages" />
        </q-card-section>
        <!-- Botones -->
        <q-card-actions align="right">
          <q-btn flat label="Cancelar" color="negative" @click="onCancel" />
          <q-btn type="submit" label="Guardar" color="primary" />
        </q-card-actions>
      </q-form>
    </q-card>
  </q-dialog>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { api } from 'src/boot/axios';
const states = ref([])
const types = ref([])
const dialog = ref(false)
const propertyData = ref({
  idProperty: null,
  name: '',
  details: '',
  address: '',
  price: 0,
  files: [],  // Imágenes o archivos
  ownerId: null,  // ID del propietario
  statePropertyId: null,  // Estado de la propiedad
  rooms: 0,
  idType: null,
  bathRooms: 0,
  totalArea: 0,
  yearsConstruction: 0,
  garden: false,
  yard: false,
  livingRoom: false,
  kitchen: false,
  dinningRoom: false,
  serviceRoom: false,
  laundryRoom: false,
  privateSecurity: false,
  pool: false,
  studio: false,
  garage: false,
  terrace: false,
  voltage220: false,
  schools: false,
  nearbyTraffic: false,
  constructionArea: false
})

const images = ref([])

function openDialog() {
  dialog.value = true
}

const closeDialog = () => {
  dialog.value = false
}

const handleImages = () => {
  // Convierte las imágenes seleccionadas a base64 y las guarda en el estado
  const reader = new FileReader();
  const imagePromises = Array.from(images.value).map(image => {
    return new Promise((resolve, reject) => {
      reader.onloadend = () => resolve(reader.result);
      reader.onerror = (error) => reject(error);
      reader.readAsDataURL(image);
    });
  });

  Promise.all(imagePromises)
    .then(encodedImages => {
      propertyData.value.files = encodedImages;  // Asigna las imágenes en base64
    })
    .catch(error => {
      console.error("Error al convertir las imágenes:", error);
    });
}

const onSubmit = async () => {
  try {
    // Enviar los datos del formulario como JSON
    const response = await api.post('/properties', propertyData.value);
    console.log('Propiedad guardada:', response.data);
    closeDialog();
  } catch (error) {
    console.error('Error al guardar los datos:', error);
  }
}
onMounted(async () => {
  try {
    const response = await api.get('/property_states')
    const response2 = await api.get('/property_types')
    console.log(response.data.body)
    states.value = response.data.body
    types.value = response2.data.body
  } catch (error) {
    console.error('Error al obtener las propiedades:', error)
  }
})

const onReset = () => {
  propertyData.value = {
    idProperty: null,
    name: '',
    details: '',
    address: '',
    price: 0,
    files: [],
    ownerId: null,
    statePropertyId: null,
    rooms: 0,
    idType: null,
    bathRooms: 0,
    totalArea: 0,
    yearsConstruction: 0,
    garden: false,
    yard: false,
    livingRoom: false,
    kitchen: false,
    dinningRoom: false,
    serviceRoom: false,
    laundryRoom: false,
    privateSecurity: false,
    pool: false,
    studio: false,
    garage: false,
    terrace: false,
    voltage220: false,
    schools: false,
    nearbyTraffic: false,
    constructionArea: false
  }
}

const onCancel = () => {
  onReset()
  closeDialog()
}

defineExpose({ openDialog })
</script>

<style scoped>
.q-card-section {
  padding: 16px;
  min-width: 500px;
}

.q-field__native {
  width: 500px !important;
}
</style>
