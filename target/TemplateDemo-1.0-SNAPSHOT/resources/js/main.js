/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function deleteThuoc(idthuoc) {
    if (confirm("Bạn chắc chắn xóa không?") == true) { 
        fetch(`/TemplateDemo/admin/api/thuoc/${idthuoc}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            
            if (res.status == 200) {
                let d = document.getElementById(`thuoc${idthuoc}`);
                alert("Hãy ấn Reload sau khi xóa!!!");
                d.style.display = "none";
                
            } else 
                alert("Something wrong!!!");
        })
    }
}

function deleteNhanVien(idNV) {
    if (confirm("Bạn chắc chắn xóa không?") == true) { 
        fetch(`/TemplateDemo/admin/api/nhanvien/${idNV}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            
            if (res.status == 200) {
                let d = document.getElementById(`nhanvien{idNV}`);
                alert("Hãy ấn Reload sau khi xóa!!!");
                d.style.display = "none";
                
            } else 
                alert("Something wrong!!!");
        })
    }
}

function deletePhieuKhamBenh(idPKB) {
    if (confirm("Bạn chắc chắn xóa không?") == true) { 
        fetch(`/TemplateDemo/api/phieukhambenh/${idPKB}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            
            if (res.status == 200) {
                let d = document.getElementById(`phieukhambenh{idPKB}`);
                alert("Hãy ấn Reload sau khi xóa!!!");
                d.style.display = "none";
                
            } else 
                alert("Something wrong!!!");
        })
    }
}

function deleteLichKham(idLK) {
    if (confirm("Bạn chắc chắn xóa không?") == true) { 
        fetch(`/TemplateDemo/api/lichkhamcanhan/${idLK}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(res => {
            
            if (res.status == 200) {
                let d = document.getElementById(`lichkhamcanhan{idLK}`);
                d.style.display = "none";
                
            } else 
                alert("Something wrong!!!");
        })
    }
}

function addToToaThuoc(idthuoc, tenthuoc, dongia, cachdung){
    event.preventDefault()
    
    fetch("/TemplateDemo/api/toathuoc", {
        method: 'post',
        body: JSON.stringify({
            "idthuoc": idthuoc,
            "tenthuoc": tenthuoc,
            "dongia": dongia,
            "quantity": 1,
            "cachdung": cachdung
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res){
        return res.json()
    }).then(function(data){
        let counter = document.getElementById("toaThuocCounter")
        counter.innerText = data
    })
}

function updateToaThuoc(obj, idthuoc){
    fetch("/TemplateDemo/api/toathuoc", {
        method: 'put',
        body: JSON.stringify({
            "idthuoc": idthuoc,
            "tenthuoc": "",
            "dongia": 0,
            "quantity": obj.value,
            "cachdung": obj.toString()
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function(res){
        return res.json()
    }).then(function(data){
        let counter = document.getElementById("toaThuocCounter")
        counter.innerText = data.counter
        let amount = document.getElementById("amountToaThuoc")
        amount.innerText = data.amount
    })
}

function deleteToaThuoc(idthuoc){
    if(confirm("Bạn chắc chắn xóa thuốc này?") == true){
        fetch(`/TemplateDemo/api/toathuoc/${idthuoc}`, {
            method: 'delete'
        }).then(function(res){
            return res.json()
        }).then(function(data){
            let counter = document.getElementById("toaThuocCounter")
            counter.innerText = data.counter
            let amount = document.getElementById("amountToaThuoc")
            amount.innerText = data.amount

            let row = document.getElementById(`toathuoc${idthuoc}`)
            row.style.display = "none"
        })
    }  
}

function thanhtoan(){
    if(confirm("Bạn xác nhận thanh toán?") == true){
        fetch("/TemplateDemo/api/thanhtoan", {
            method: "post"
        }).then(function(res){
            return res.json();
        }).then(function(code){
            console.info(code);
            location.reload();
        })
    }
}






