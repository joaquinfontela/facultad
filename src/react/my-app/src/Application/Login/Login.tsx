import React, { ChangeEvent } from 'react'
import { textChangeRangeIsUnchanged } from 'typescript';
import "./Login.css"

interface LoginState {
    input: string
    validInput: boolean
    sentInput: boolean
}

export class Login extends React.Component<{}, LoginState> {

    constructor(props: any) {
        super(props);
        this.state = {
            input: "",
            validInput: false,
            sentInput: false
        }
    }

    handleInputChange(newInput: string): void {
        this.setState({
            input: newInput,
            validInput: /^\d+$/.test(newInput), // esto valida que todos los caracteres de una str sean digitos.
            sentInput: false
        })
    }

    handleInputSubmit(eventCode: string): void {
        if (eventCode === "Enter") {
            this.setState({
                sentInput: true // esto valida que todos los caracteres de una str sean digitos.
            })
        }
    }

    render(): JSX.Element {
        if (!this.state.sentInput) {
            return (
                <div>
                    <input className="loginInput" value={this.state.input} placeholder="Login"
                        onChange={e => this.handleInputChange(e.target.value)} onKeyPress={e => this.handleInputSubmit(e.code)}></input >
                </div >
            );
        } else if (this.state.validInput) {
            return (
                <div>
                    <input className="loginInput" value={this.state.input} placeholder="Login"
                        onChange={e => this.handleInputChange(e.target.value)} onKeyPress={e => this.handleInputSubmit(e.code)}></input >
                    <div className="successfulLoginMessage">Login exitoso.</div>
                </div >
            );
        } else {
            return (
                <div>
                    <input className="loginInput" value={this.state.input} placeholder="Login"
                        onChange={e => this.handleInputChange(e.target.value)} onKeyPress={e => this.handleInputSubmit(e.code)}></input >
                    <div className="unsuccessfulLoginMessage">ID no registrado.</div>
                </div >
            );
        }
    }
}