<template>
  <v-container>
    <v-row class="text-center">
      <v-col>
        <h4>
          Willkommen zu meinem Quadrierungsservice!
        </h4>
      </v-col>
      <v-col cols="12">
        <input v-model="number" placeholder="Bitte Zahl Eingeben">
      </v-col>
      <v-col cols="12">
        <button id="starter" @click="startService">{{number}} wird übertragen</button>
      </v-col>
      <v-col class="mb-4">
      <p>
        {{number}} zum Quadrat ist:
        <span> {{result}} </span>
      </p>
    </v-col>
      <v-col cols="12">
        <button id="saver" @click="databankStartUp">{{number}} und {{result}} in die
                            h2 in-memory-Datenbank speichern!
        </button>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup lang="ts">
import { ref } from "vue";

import { API_BASE} from "@/Constants";
import FetchUtils from "@/api/FetchUtils";

const number = ref();
const result = ref();

function startService() {
  if (!number.value) {
    // eslint-disable-next-line no-console
    console.error("Die Nummer ist nicht definiert.");
    return;
  }
  const url = `${API_BASE}/cal?number=${encodeURIComponent(number.value)}`;
  fetch(url, FetchUtils.getGETConfig())
    .then((response) => {
      FetchUtils.defaultResponseHandler(
        response,
        `Beim Laden des Textes ist ein Fehler aufgetreten.  ${response.status}`
      );
      return response.text();
    })
    .then((text) => {
      result.value = text; // Ergebnis in `result` speichern
    })
    .catch((error) => {
      // eslint-disable-next-line no-console
      console.error("Fehler beim Abrufen der Antwort:", error);
    });
}

function databankStartUp(){
  if (!number.value) {
    // eslint-disable-next-line no-console
    console.error("Die Nummer ist nicht definiert.");
    return;
  }
  const url = `${API_BASE}/sending?number=${encodeURIComponent(number.value)}`;
  fetch(url, FetchUtils.getGETConfig())
      .then((response) => {
        FetchUtils.defaultResponseHandler(
            response,
            `Beim Laden des Textes ist ein Fehler aufgetreten.  ${response.status}`
        );
        return response.text();
      })
      .catch((error) => {
        // eslint-disable-next-line no-console
        console.error("Fehler beim Abrufen der Antwort:", error);
      });
}
</script>
<style scoped>
#starter{
  width: 225px;
  height: 50px;
  border: solid black;
}

#saver{
  width: 250px;
  height: 100px;
  border: solid black;
}

</style>
