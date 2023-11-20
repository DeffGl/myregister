function moveToSelected() {
    moveOptions('districts', 'selectedDistricts');
}

function moveToDistricts() {
    moveOptions('selectedDistricts', 'districts');
}

function moveOptions(sourceId, targetId) {
    var sourceSelect = document.getElementById(sourceId);
    var targetSelect = document.getElementById(targetId);

    var selectedOptions = Array.from(sourceSelect.selectedOptions);
    // Получаем все элементы внутри <select>
    var allOptions = sourceSelect.options;
    selectedOptions.forEach(function (option) {
        targetSelect.appendChild(option);
    });
    updateHiddenField();
}

function updateHiddenField() {
    var selectedDistricts = document.getElementById('selectedDistricts');
    var hiddenField = document.getElementById('selectedDistrictsHidden');
    var values = [];

    for (var i = 0; i < selectedDistricts.options.length; i++) {
        values.push(selectedDistricts.options[i].value);
    }

    hiddenField.value = values.join(',');
    console.log(hiddenField);
}