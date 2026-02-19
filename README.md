# Unit Converter

A modular unit conversion web application built with **Spring Boot**, **Spring MVC**, and **Thymeleaf**.  
It supports conversion between **length**, **weight**, and **temperature** units using a consistent enum-based
architecture.

---

## Features

### Length Conversion

- Supported units: `mm`, `cm`, `m`, `km`, `in`, `ft`, `yd`, `mi`
- Internally normalized to **meters**
- Factor-based enum logic

### Weight Conversion

- Supported units: `mg`, `g`, `kg`, `t`, `oz`, `lb`
- Internally normalized to **grams**
- Factor-based enum logic

### Temperature Conversion

- Supported units: `C`, `F`, `K`
- Internally normalized to **Kelvin**
- Enum stores:
    - **factor** (multiplicative)
    - **offsetToKelvin** (additive)
- Conversion formula:
    - kelvin = value * factor + offsetToKelvin
- Reverse formula:
    - value = (kelvin - offsetToKelvin) / factor

---

## Technology Stack

- Java 17+
- Spring Boot
- Spring MVC
- Thymeleaf
- HTML / CSS (custom UI)

---

## Running the Application

Build and run with:

```bash
./mvnw spring-boot:run

Open in the browser:
http://localhost:8080
```

## How Conversion Works

1. Input is accepted through a Thymeleaf form 
2. The controller validates and forwards it to the appropriate service 
3. Service converts the input into a base unit 
4. Base value is converted into the target unit 
5. The controller formats the output (rounding, integer clean-up)
6. The result is displayed on the UI

## Extending the Application
### To add a new unit:

1. Add it to the correct enum 
2. Set its factor (and offset for temperature)
3. Add an option in the corresponding HTML 'select' menu

No further code changes are required.

# License
This project is free for personal and educational use.

# Author
Bernhard Oberlechner
