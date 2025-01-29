import tkinter as tk
from tkinter import messagebox, mainloop


import requests
import json

def get_repo_info():
    repo_name = entry.get().strip()
    if not repo_name:
        messagebox.showerror('Ошибка, введите название репозитория')
        return

    url = f"https://api.github.com/repos/{repo_name}"
    try:
        response = requests.get(url)
        response.raise_for_status()
        data = response.json()

        result = {
            "company": data.get('owner', {}).get("company", "N/A"),
            "created_at": data.get('created_at', "N/A"),
            "email": data.get('email', "N/A"),
            "name": data.get('name', "N/A"),
            "url": data.get('html_url', "N/A"),
        }

        with open("repo_info.json", "w", encoding="utf-8") as file:
            json.dump(result, file, ensure_ascii=False, indent=4)

        messagebox.showinfo(f'Успех', "данные репозитория сохранены в файл repo_info.json")
    except requests.exceptions.RequestException as e:
        messagebox.showinfo(f'Ошибка', "не удалось получить данные {e}")
    except Exception as e:
        messagebox.showerror("Ошибка", f'Произошла ошибка: {e}')

root = tk.Tk()
root.title('Repo info')

tk.Label(root, text='Введите название репозитория:')
entry = tk.Entry(root, width=40)
entry.pack(pady=5)

btn = tk.Button(root, text='Получить данные', command=get_repo_info)
btn.pack(pady=5)

root = mainloop()