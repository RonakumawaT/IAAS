document.getElementById("translate").addEventListener("click", async () => {
  const text = document.getElementById("text").value.trim();
  const language = document.getElementById("language").value;

  if (!text) {
    alert("Please enter text to translate.");
    return;
  }

  try {
    const res = await fetch("http://localhost:8080/api/translate", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ text, targetLanguage: language })
    });

    if (!res.ok) {
      const err = await res.json();
      throw new Error(err.message || "Server error");
    }

    const data = await res.json();
    document.getElementById("output").innerText = data.text;

  } catch (err) {
    document.getElementById("output").innerText = "Error: " + err.message;
  }
});
