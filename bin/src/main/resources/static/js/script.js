var swiper = new Swiper(".slide-content", {
    slidesPerView: 3,
    spaceBetween: 25,
    loop: true,
    centerSlide: 'true',
    fade: 'true',
    grabCursor: 'true',
    pagination: {
      el: ".swiper-pagination",
      clickable: true,
      dynamicBullets: true,
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },

    breakpoints:{
        0: {
            slidesPerView: 1,
        },
        520: {
            slidesPerView: 2,
        },
        950: {
            slidesPerView: 3,
        },
    },
  });
  
document.addEventListener('DOMContentLoaded', function() {
    const aboutBtn = document.getElementById('aboutBtn');
    const slider = document.querySelector('.slide-container');

    aboutBtn.addEventListener('click', function() {
        // Add a class to the slider to trigger the blinking effect
        slider.classList.add('blink');
        // Add shadow effect
        slider.classList.add('shadow');

        // After 1 second, remove the class to stop the blinking effect
        setTimeout(function() {
            slider.classList.remove('blink');
            // Remove shadow effect after 1 second
            setTimeout(function() {
                slider.classList.remove('shadow');
            }, 1000);
        }, 1000);
    });
  });
