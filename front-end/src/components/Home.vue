<template>
  <div>
    <b-carousel
      id="carousel-1"
      :interval="4000"
      controls
      indicators
      fade
      img-width="1024"
      img-height="480"
      style="text-shadow: 1px 1px 2px #333;"
    >
      <!-- Slides with alt text -->
      <b-carousel-slide
      caption="Vida Fit Logo" 
      img-src="https://i.ibb.co/B25NbJJ/vidafit.png"
      ></b-carousel-slide>
      
      <!-- Slides with alt text -->
      <b-carousel-slide
        caption="Person Jogging" 
        img-src="https://images.everydayhealth.com/images/consisten-exercise-helps-anxiety-and-stress-1440x810.jpg"
      ></b-carousel-slide>

      <!-- Slides with alt text -->
      <b-carousel-slide
        caption="Person Meditating" 
        img-src="https://cdn.shrm.org/image/upload/c_crop%2Ch_704%2Cw_1254%2Cx_0%2Cy_0/c_fit%2Cf_auto%2Cq_auto%2Cw_767/v1/Tools%20and%20Samples/tk_wellness_sdydf0?databtoa=eyIxNng5Ijp7IngiOjAsInkiOjAsIngyIjoxMjU0LCJ5MiI6NzA0LCJ3IjoxMjU0LCJoIjo3MDR9fQ%3D%3D"></b-carousel-slide>

    </b-carousel>

  <footer>
    <p>Copyright &copy; 2022</p>
  </footer>


  </div>
</template>

<script>
export default {
  name: 'Home',
  data () {
    return {
    }
  }
}
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
