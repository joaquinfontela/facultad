import React, { ChangeEvent } from 'react'
import { textChangeRangeIsUnchanged } from 'typescript';
import "./Login.css"
import ApiHandler from "../API/ApiHandler"

interface LoginState {
    input: string
    validInput: boolean
    sentInput: boolean
}

interface LoginProps {
    initialSentInput: boolean,
    successFulLoginHandler: any
}

export class Login extends React.Component<LoginProps, LoginState> {

    constructor(props: any) {
        super(props);
        this.state = {
            input: "",
            validInput: true,
            sentInput: this.props.initialSentInput
        }
    }

    handleInputChange(newInput: string): void {
        this.setState({
            input: newInput,
            sentInput: false
        })
    }

    async handleInputSubmit(eventCode: string): Promise<void> {
        if (eventCode === "Enter") {
            const validInput: boolean = await this.validateInput(this.state.input);
            if (validInput) {
                this.props.successFulLoginHandler(this.state.input);
            }
            this.setState({
                sentInput: true,
                validInput
            })
        }
    }

    async validateInput(loginId: string): Promise<boolean> {
        return await new ApiHandler().validateStudentId(loginId);
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