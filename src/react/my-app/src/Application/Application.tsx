import React from 'react';
import { Title } from './Title/Title'
import { ButtonMenu } from './ButtonMenu/ButtonMenu'
import { ResultsWindow } from './ResultsWindow/ResultsWindow'
import { Login } from "./Login/Login"

interface ApplicationState {
    renderResults: string,
    studentId: string,
    loggedIn: boolean
}

export class Application extends React.Component<{}, ApplicationState> {

    constructor(props: any) {
        super(props);
        this.state = {
            loggedIn: false,
            studentId: "",
            renderResults: ""
        }
        this.handleButtonClick = this.handleButtonClick.bind(this);
        this.handleSuccessfulLogin = this.handleSuccessfulLogin.bind(this);
    }

    handleButtonClick(buttonId: string): void {
        this.setState({
            renderResults: buttonId
        });
    }

    handleSuccessfulLogin(studentId: string) {
        this.setState({
            loggedIn: true,
            studentId
        })
    }

    render(): JSX.Element {

        return (
            <div>
                <Title />
                <Login successFulLoginHandler={this.handleSuccessfulLogin} initialSentInput={this.state.loggedIn} />
                <div>
                    <ButtonMenu onClick={this.handleButtonClick} enabledMenu={this.state.loggedIn} />
                    <ResultsWindow renderId={this.state.renderResults} studentId={this.state.studentId} />
                </div>
            </div>
        );
    }
}