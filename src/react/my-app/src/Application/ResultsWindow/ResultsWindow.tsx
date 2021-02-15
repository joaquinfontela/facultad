import React from 'react'
import './ResultsWindow.css'
import { CreditsWindow } from './CreditsWindow/CreditsWindow'
import { AvailableWindow } from './AvailableWindow/AvailableWindow';
import { PassedWindow } from './PassedWindow/PassedWindow'
import { RemainingWindow } from './RemainingWindow/RemainingWindow'
import { HelpWindow } from "./HelpWindow/HelpWindow"
import { UpdateWindow } from "./UpdateWindow/UpdateWindow"

interface ResultsWindowProps {
    renderId: string
}

export class ResultsWindow extends React.Component<ResultsWindowProps> {

    render(): JSX.Element {
        switch (this.props.renderId) {
            case ('available'):
                return (
                    <div className="resultsWindowBox">
                        <AvailableWindow />
                    </div>
                );
            case ('credits'):
                return (
                    <div className="emptyResultsWindowBox">
                        <CreditsWindow />
                    </div>
                );
            case ('passed'):
                return (
                    <div className="resultsWindowBox">
                        <PassedWindow />
                    </div>
                );
            case ('remaining'):
                return (
                    <div className="resultsWindowBox">
                        <RemainingWindow />
                    </div>
                );
            case ('update'):
                return (
                    <div className="resultsWindowBox">
                        <UpdateWindow />
                    </div>
                );
            default:
                return (
                    <div className="resultsWindowBox">
                        <HelpWindow />
                    </div>
                );
        }
    }
}