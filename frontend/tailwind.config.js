/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./index.html", "./src/**/*.{vue,js,ts,jsx,tsx}"],
  theme: {
    extend: {
      colors: {
        "back_elem_col": "#E6CCB2",
        "second_col": "#582F0E",
        "third_col": "#9C6644",
        "fourth_col": "#FB5607"
      },
      fontFamily: {
        RobotoSlab: ["Roboto Slab, sans-serif"]
      }
    },
  },
  plugins: [],
}

