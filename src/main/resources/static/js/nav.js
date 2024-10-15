const hamburgerElements = document.querySelectorAll(".hamburger");

hamburgerElements.forEach(hamburgerElement => {
  hamburgerElement.addEventListener("click", () => {
    const wrapperElement = document.querySelector(".wrapper");
    wrapperElement.classList.toggle("collapse");
  });
});
