const search = document.getElementById("formSearch");
const button = document.getElementById("submit");
const els = document.querySelector(".spin-container");

search.addEventListener("submit", function (event) {
  console.log(document.getElementById("descDecisao").value);

  els.style.display = 'flex';

  setTimeout(() => {

    els.style.display = 'none';
    console.log("setTimeOut disparado");
  }, 10000);

})